package angus.gmoni.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import angus.gmoni.domain.CpuData;
import angus.gmoni.domain.Pk;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CpuDataRepoTest {
	
	@Autowired
	CpuDataRepo cpuDataRepo;

	static  Pk id =  new Pk("agentid",new Date());
   
	@Test
	public void testSaveS() {
		
		CpuData cpu = new CpuData();
		cpu.setId(id);
		cpu.setIrq(0.759);;
		
		cpuDataRepo.save(cpu);
		
	}



}

