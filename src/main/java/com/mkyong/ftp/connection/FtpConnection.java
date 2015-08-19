package com.mkyong.ftp.connection;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.file.remote.session.Session;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.integration.ftp.session.FtpSession;
import org.springframework.stereotype.Component;

@Component("ftpConnection")
public class FtpConnection {
	private static final Logger logger = Logger.getLogger(FtpConnection.class);

	private static final int BUFFER_SIZE = 8096;

	@Autowired
	@Qualifier("ftpClientFactory")
	DefaultFtpSessionFactory dfFtpSession;

	/*
	 * 
	 * @param folder String Folder name
	 * 
	 * @return InputStream byte output one image file
	 */
	public void outRequestFolder(String folder, HttpServletResponse response) {
		logger.info("start outRequestFolder");
		FTPFile[] ftpFil = null;
		PrintWriter printwrite = null;
		ServletOutputStream outStream = null;
		Session<FTPFile> sess = (FtpSession) dfFtpSession.getSession();
		InputStream inputFtpFile = null;
		try {
			// ftpFil = sess.list("/home/sergey/");//ubuntu
			ftpFil = sess.list("/");
			logger.info("dir" + ftpFil.length);
			for (FTPFile f : ftpFil) {
				if (f.getName().equals(folder)) {
					String name = f.getName();
					String mimeType = "application/zip";
					response.setContentType(mimeType);
					int size = (int) f.getSize();
					response.setContentLength(size);
					String headerKey = "Content-Disposition";
					String headerValue = String.format(
							"attachment; filename=\"%s\"", name);
					response.setHeader(headerKey, headerValue);
					inputFtpFile = sess.readRaw(name);
					outStream = response.getOutputStream();
					byte[] buffer = new byte[BUFFER_SIZE];
					logger.info(name + "," + mimeType + "");
					int bytesRead = -1;
					while ((bytesRead = inputFtpFile.read(buffer)) != -1) {
						outStream.write(buffer, 0, bytesRead);

					}
					inputFtpFile.close();
					outStream.close();
				}
			}

		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * @param String File name
	 * 
	 * @return InputStream byte output file
	 */
	public InputStream outRequestFile(String fileName) throws IOException {
		InputStream ftpFile = null;
		Session<FTPFile> sess = (FtpSession) dfFtpSession.getSession();
		if (sess != null) {
			ftpFile = sess.readRaw(fileName);
		}

		return ftpFile;

	}

	/*
	 * @param String File name
	 * 
	 * @return long size output file
	 */

	public long outSizeFile(String fileName) {

		long size = 0;
		Session<FTPFile> sess = (FtpSession) dfFtpSession.getSession();

		try {
			FTPFile[] ftpFil = sess.list("/");
			for (FTPFile f : ftpFil) {
				if (f.getName().equals(fileName)) {
					size = f.getSize();
				}
			}

		} catch (IOException e) {

			logger.error(e);
		}

		return size;

	}

	/**
	 * return in threat zip file image
	 * 
	 * @param name
	 * @param response
	 * @throws IOException
	 */
	public void getFildZipImage(String name, HttpServletResponse response)
			throws IOException {
		String names = null;
		InputStream inputFile = null;
		File fie = null;
		names = name + ".zip";
		inputFile = (InputStream) outRequestFile(names);
		String mimeType = "application/zip";
		response.setContentType(mimeType);
		long size = outSizeFile(name);
		response.setContentLength((int) size);
		String headerKey = "Content-Disposition";
		String headerValue = String
				.format("attachment; filename=\"%s\"", names);
		response.setHeader(headerKey, headerValue);
		ServletOutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;
		while ((bytesRead = inputFile.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputFile.close();
		outStream.close();
	}

}