package com.jmonkey.xtracker.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.hibernate.type.StringType;

import com.jmonkey.xtracker.util.Parser;

public class ParserType extends StringType {

	public ParserType() {
		super();
	}

	@Override
	public boolean equals(Object arg0, Object arg1) {
		return super.equals(arg0, arg1);
	}

	@Override
	public Object get(ResultSet resultSet, String name) throws SQLException {
		String statusName = (String) super.get(resultSet, name);
		Parser result = Parser.valueOf(statusName);
		return result;
	}

	@Override
	public String getName() {
		return "parser";
	}

	@Override
	public Class getReturnedClass() {
		return Parser.class;
	}

	@Override
	public void set(PreparedStatement statement, Object value, int index) throws SQLException {
		Parser status = (Parser) value;
		super.set(statement, status.name(), index);
	}

	@Override
	public Object stringToObject(String string) throws Exception {
		return Parser.valueOf(string);
	}

	@Override
	public String toString(Object object) {
		if (object instanceof Parser) {
			return ((Parser) object).name();
		}
		return super.toString(object);
	}

}
