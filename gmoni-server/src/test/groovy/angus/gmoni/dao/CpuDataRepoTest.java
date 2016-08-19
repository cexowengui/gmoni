package angus.gmoni.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import angus.gmoni.domain.CpuStatus;
import angus.gmoni.domain.Pk;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CpuDataRepoTest {
	
	@Autowired
	CpuStatusRepo cpuDataRepo;

	static  Pk id =  new Pk("agentid",new Date());
   
	@Test
	public void testSaveS() {
		
		CpuStatus cpu = new CpuStatus();
		cpu.setAgent("first agent");
		cpu.setQuerytime(new Date());
		cpu.setIrq(0.333355);
		cpuDataRepo.save(cpu);
		
	}
	
	@Test
	public void testFindByAgent(){
		List<CpuStatus> cpus = cpuDataRepo.findByAgent("first agent");
		
		assert cpus != null;
		System.out.println(cpus.get(0).getIrq());
		
	}



}

