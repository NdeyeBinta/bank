package com.dao;

import java.util.List;


import com.entities.Type;

public interface IType {
	public List<Type> liste();
	public Type get(int  idtype);

}
