package com.ljtao.RESTfulspringboot;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/tvseries")
public class TvseriesController {

	@Value("${spring.jackson.date-format}")
	private String  testString ;
	//@Autowired
	//private Sender sender;

	//consumes是request接收得格式  ,produces=MediaType.IMAGE_JPEG_VALUE输出数据形式
	@PostMapping(value="/{id}/photos",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public void addPhoto(@PathVariable int id ,@RequestParam("photo") MultipartFile imgFile) throws Exception {
		FileOutputStream fos=new FileOutputStream("target/"+imgFile.getOriginalFilename());
		IOUtils.copy(imgFile.getInputStream(),fos);
		fos.close();
	}
	//这里要用DELETE方式，在url上传递参数进来
	@DeleteMapping("/{id}")
	public Map<String,String> deleteOne(@PathVariable int id,HttpServletRequest request,
			@RequestParam(value="delete_reason",required=false) String deleteReason) throws Exception
	{
		Map<String,String> map=new HashMap<>();
		if(id==101){
			map.put("message", "#"+id+"被"+request.getRemoteAddr()+"删除（原因:"+deleteReason); 
		}
		else if(id==102){
			throw new RuntimeException("102不能被删除");
		}
		else{
			throw new ResourceNotFoundException();
		}
		return map;
	}
	@PutMapping("/{id}")
	public TvSeriesDto updateOne(@PathVariable int id,@RequestBody(required=false) TvSeriesDto tvSeriesDto){
		if(id==101||id==102){
			//根据信息更新数据，并返回
			System.out.println("updateOne"+tvSeriesDto.getName());
			return create1();
		}
		else{
			throw new  ResourceNotFoundException();
		}
	}
	@PostMapping
	public TvSeriesDto insertOne(@RequestBody TvSeriesDto tvSeriesDto){
		tvSeriesDto.setId(9999);
		return tvSeriesDto;
	}
	@GetMapping("/{id}")
	public TvSeriesDto getOne(@PathVariable int id){
		if(id==101){
			return create1();
		}else if(id==102){
			return create2();
		}
		else{
			throw new ResourceNotFoundException();
		}
	}
	public static  TvSeriesDto create1(){
		Calendar calendar= Calendar.getInstance();
		calendar.set(2016,Calendar.OCTOBER,2,0,0);
		return new TvSeriesDto(1,"west",1,calendar.getTime());
	}
	public static  TvSeriesDto create2(){
		Calendar calendar= Calendar.getInstance();
		calendar.set(2016,Calendar.OCTOBER,3,0,0);
		return new TvSeriesDto(1,"west",1,calendar.getTime());
	}
	@GetMapping
	public Map<String,Object> sayHello(){
		Map<String ,Object> map=new HashMap<>();
		map.put("message","hello world.");
		return map;
	}
	//private static final Log log=LogFactory.getLog(TvseriesController.class);
	@RequestMapping("/fun2")
	public List<TvSeriesDto> fun1() throws Exception{
		//if(log.isTraceEnabled())
			//log.trace("fun1()被调用了");
		List<TvSeriesDto> list=new ArrayList<>();
		Calendar calendar= Calendar.getInstance();
		calendar.set(2016,Calendar.OCTOBER,2,0,0);
		System.out.println(testString);
		int n=1;
		if(n==1) {
			//throw new BussinesException("-1", "自定义异常信息");
		}


		list.add(new TvSeriesDto(1,"west",1,calendar.getTime()));
		return list;
	}
}
