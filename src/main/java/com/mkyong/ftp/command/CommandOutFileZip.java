package com.mkyong.ftp.command;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mkyong.ftp.connection.FtpConnection;

/**
 * Command downloads zip one file
 * 
 * @author Sergey
 *
 */
@Component("CommandOutFileZip")
public class CommandOutFileZip implements ICommandOUtZip {
	private static final Logger logger = Logger
			.getLogger(CommandOutFileZip.class);
	@Autowired
	@Qualifier("ftpConnection")
	private FtpConnection ftpConnection;

	@Override
	public void execute(String nameFolder, HttpServletResponse response) {
		logger.info("dir Command");
		try {
			ftpConnection.getFildZipImage(nameFolder, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}

	@Override
	public String toString() {

		return "CommandOutFileZip";

	}
}
