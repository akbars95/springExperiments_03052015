package com.mtsmda.souvenir.repository.impl.java_standard.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mtsmda.souvenir.model.Message;
import static com.mtsmda.souvenir.model.sp.MessageSP.*;

public class MessageMapper implements RowMapper<Message> {

	@Override
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message message = new Message();
		message.setMessageId(rs.getInt(MESSAGE_ID));
		message.setMessageName(rs.getString(MESSAGE_NAME));
		message.setMessageCaptcha(rs.getInt(MESSAGE_CAPTCHA_ID));
		message.setMessageEmail(rs.getString(MESSAGE_EMAIL));
		message.setMessageText(rs.getString(MESSAGE_TEXT_M));
		return message;
	}

}