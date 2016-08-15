package angus.gmoni.web

import groovy.json.JsonBuilder
import groovy.transform.TypeChecked

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController;

import angus.gmoni.domain.FileInfo
import angus.gmoni.service.FileService

@TypeChecked
@Controller
class FileController {

	@Autowired
	private FileService fileService

	@RequestMapping(value="/file", method=RequestMethod.POST)
	@ResponseBody
	public FileInfo getFile(@RequestParam(value="path", required=false) String path) throws IOException {
		
		return fileService.getPath(path)
	}

	@RequestMapping(value="/file/list", method=RequestMethod.POST)
	@ResponseBody
	public List<File> listFiles(@RequestParam(value="path", required=false) String path) throws IOException {
		if (path == "" || path == null) {
			return fileService.listRoots()
		} else {
			return fileService.listPaths(path)
		}
	}
}
