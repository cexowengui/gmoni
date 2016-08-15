package angus.gmoni.domain


import com.fasterxml.jackson.annotation.JsonProperty

/*
 * size used available 都是KB单位
 */
class FileInfo {


	 String name	
	 double size //文件大小 long KB
	 long total //总的大小 kb
	 long used //已使用 kb
	 long available //可用大小KB

	@JsonProperty("is_dir")
	 boolean isDirectory
	@JsonProperty("is_file")
	 boolean isRegularFile
	
	@JsonProperty("is_sym_link")
	 boolean isSymbolicLink

	 boolean hidden
	
	/*
	 * 格式化的LocalDateTime String
	 */
	@JsonProperty("last_modified")
	 String lastModifiedTime
	
	 String onwer
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setSize(long size) {
//		this.size = size;
//	}
//
//	public void setTotal(long total) {
//		this.total = total;
//	}
//
//	public void setUsed(long used) {
//		this.used = used;
//	}
//
//	public void setAvailable(long available) {
//		this.available = available;
//	}
//
//	public void setDirectory(boolean isDirectory) {
//		this.isDirectory = isDirectory;
//	}
//
//	public void setRegularFile(boolean isRegularFile) {
//		this.isRegularFile = isRegularFile;
//	}
//
//	public void setSymbolicLink(boolean isSymbolicLink) {
//		this.isSymbolicLink = isSymbolicLink;
//	}
//
//	public void setHidden(boolean hidden) {
//		this.hidden = hidden;
//	}
//
//	public void setLastModifiedTime(String lastModifiedTime) {
//		this.lastModifiedTime = lastModifiedTime;
//	}
//
//	public void setOnwer(String onwer) {
//		this.onwer = onwer;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public long getSize() {
//		return size;
//	}
//
//	public long getTotal() {
//		return total;
//	}
//
//	public long getUsed() {
//		return used;
//	}
//
//	public long getAvailable() {
//		return available;
//	}
//
//	public boolean isDirectory() {
//		return isDirectory;
//	}
//
//	public boolean isRegularFile() {
//		return isRegularFile;
//	}
//
//	public boolean isSymbolicLink() {
//		return isSymbolicLink;
//	}
//
//	public boolean isHidden() {
//		return hidden;
//	}
//
//	public String getLastModifiedTime() {
//		return lastModifiedTime;
//	}
//
//	public String getOnwer() {
//		return onwer;
//	}
//	
//	
//	
	

}
