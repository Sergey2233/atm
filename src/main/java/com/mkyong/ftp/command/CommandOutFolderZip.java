package com.mkyong.ftp.command;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mkyong.ftp.connection.FtpConnection;

/**
 * 
 * @author Sergey class unloads zip folder
 */
@Component("CommandOutFolderZip")
public class CommandOutFolderZip implements ICommandOUtZip {
	private static final Logger logger = Logger
			.getLogger(CommandOutFolderZip.class);

	@Autowired
	@Qualifier("ftpConnection")
	FtpConnection ftpConnection;

	/**
	 * empty constructor
	 */
	public CommandOutFolderZip() {
		super();

	}

	@Override
	public void execute(String nameFolder, HttpServletResponse response) {
		nameFolder += ".zip";

		if (ftpConnection == null) {
			logger.warn("ftpConnection warn");
		} else {
			ftpConnection.outRequestFolder(nameFolder, response);
		}
	}

	@Override
	public String toString() {

		return "CommandOutFZip";

	}

}