package angus.gmoni.service.impl


import java.io.IOException
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path
import java.nio.file.Paths
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service

import angus.gmoni.domain.FileInfo;
import angus.gmoni.service.FileService
import groovy.transform.TypeChecked;;

@TypeChecked
@Service("fileService")
class FileServiceImpl implements FileService{



	@Override
	public FileInfo getPath(String path) throws IOException {
		if(path == ".") path=""

		Path p = Paths.get(path)

		return getFileInfo(p);
	}

	@Override
	public List<FileInfo> listRoots() throws IOException {
		List<FileInfo> list = new ArrayList<>()
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories()
		for (Path name : dirs) {
			list.add(getFileInfo(name))
		}
		return list;
	}

	/**
	 * 返回指定目录中的文件信息，不遍历子目录
	 */
	@Override
	public List<FileInfo> listPaths(String path) throws IOException {
		List<FileInfo> list = new ArrayList<>()

		DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))
		for(Path file:stream){
			list.add(getFileInfo(file))
		}

		return list
	}



	private FileInfo getFileInfo(Path path){
		if(!Files.exists(path)){
			return null
		}
		FileInfo fi = new FileInfo()
		fi.isRegularFile = Files.isRegularFile(path)
		fi.isDirectory = Files.isDirectory(path)
		fi.hidden = Files.isHidden(path)
		fi.isSymbolicLink = Files.isSymbolicLink(path)

		Date date = new Date(Files.getLastModifiedTime(path).toMillis())
		LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
		String when = ldt.format(f)
		fi.lastModifiedTime = when

		fi.name = path.getFileName()
		fi.onwer = Files.getOwner(path).toString()
		fi.size = (long) Files.size(path)	/ 1024
		FileStore store = Files.getFileStore(path);

		fi.total =(long) store.getTotalSpace() / 1024
		fi.used = (long)  (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024
		fi.available =(long)   store.getUsableSpace() / 1024

		return fi
	}
}
