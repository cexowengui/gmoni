package angus.gmoni.domain


import com.fasterxml.jackson.annotation.JsonProperty

/*
 * size used available ����KB��λ
 */
class FileInfo {


	String name
	double size //�ļ���С long KB
	long total //�ܵĴ�С kb
	long used //��ʹ�� kb
	long available //���ô�СKB

	@JsonProperty("is_dir")
	boolean isDirectory
	@JsonProperty("is_file")
	boolean isRegularFile

	@JsonProperty("is_sym_link")
	boolean isSymbolicLink

	boolean hidden

	/*
	 * ��ʽ����LocalDateTime String
	 */
	@JsonProperty("last_modified")
	String lastModifiedTime

	String onwer


}
