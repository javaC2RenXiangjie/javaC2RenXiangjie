package com.java2.web.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.java2.web.entities.PersonEntity;

@Repository
public class PersonRepo implements IPersonRepository{

	private Date nowTime = new Date();
	private DateFormat times = DateFormat.getTimeInstance();
	private static final Logger logger = LoggerFactory.getLogger(PersonRepo.class);
	private String time = times.format(nowTime);
	public static void writeToFile(String str){
		BufferedWriter bw = null;
		OutputStream os = null;
		try {
			os = new FileOutputStream(new File("./deletePerson.log"), true);
			Writer write = new OutputStreamWriter(os);
			bw = new BufferedWriter(write);
			bw.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public List<PersonEntity> getPersons(){
		return em.createQuery("from PersonEntity",PersonEntity.class).getResultList();
	}
	
	@Override
	public int addPerson(PersonEntity person) {
		writeToFile(time + "   增加操作： "  + person.toString() + "\n");
		em.persist(person);
		return person.getId();
	}

	
	@Override
	public void deletePerson(Integer id) {
		PersonEntity pe = em.find(PersonEntity.class, id);
		writeToFile(time + "   删除操作：" + "\t contents:"+ pe.toString() + "\n");
		em.remove(pe);
	}

	@Override
	public PersonEntity getPersonById(Integer id){
		return em.find(PersonEntity.class, id);
	}

	@Override
	public void updatePerson(PersonEntity person) {
		PersonEntity pe = em.find(PersonEntity.class, person.getId());
		writeToFile(time + "   更改操作：  ");
		if(!pe.getName().equals(person.getName())){
			writeToFile("Name属性：" + pe.getName() + " 改为--->" + person.getName() + "\t");
		}
		if(!pe.getSex().equals(person.getSex())){
			writeToFile("Sex属性： " + pe.getSex() + " 改为--->" + person.getSex() + "\t");
		}
		writeToFile("\n");
		em.merge(person);
	}
}
