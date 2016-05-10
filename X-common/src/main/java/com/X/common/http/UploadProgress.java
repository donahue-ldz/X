package com.X.common.http;

public interface UploadProgress {
	/**
	 * 上传数据的回调函数调用
	 * 
	 * @param uploaded	已经上传的字节数
	 * @param total     字节总数
	 */
	void onUpload(long uploaded, long total);

	UploadProgress DEFAULT = new UploadProgress() {
		public void onUpload(long uploaded, long total) {
		}
	};
}