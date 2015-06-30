package jane.course.java.spring.mvc.domain;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.keyvalue.DefaultKeyValue;

public class User {
	private List<String> sexList = Arrays.asList("female", "male");
	private List<DefaultKeyValue<String, String>> marriedList = Arrays.asList(
			new DefaultKeyValue<String, String>("已婚", "married"),
			new DefaultKeyValue<String, String>("未婚", "unmarried")
	);
	private List<String> ageList = Arrays.asList(
			"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
			"30", "31", "32", "33", "34", "35", "36", "37", "38", "39"
	);
	private List<DefaultKeyValue<String, String>> degreeList = Arrays.asList(
			new DefaultKeyValue<String, String>("大专", "junior"),
			new DefaultKeyValue<String, String>("本科", "regular")
	);
	private List<DefaultKeyValue<String, String>> interestList = Arrays.asList(
			new DefaultKeyValue<String, String>("电影", "movie"),
			new DefaultKeyValue<String, String>("游戏", "games")
	);
	
	private String username;
	private String password;
	private String sex;
	private String married;
	private String age;
	private String degree;
	private List<String> interest;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public List<String> getInterest() {
		return interest;
	}
	public void setInterest(List<String> interest) {
		this.interest = interest;
	}
	public List<String> getSexList() {
		return sexList;
	}
	public List<DefaultKeyValue<String, String>> getMarriedList() {
		return marriedList;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public List<String> getAgeList() {
		return ageList;
	}
	public List<DefaultKeyValue<String, String>> getDegreeList() {
		return degreeList;
	}
	public List<DefaultKeyValue<String, String>> getInterestList() {
		return interestList;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", sex=" + sex + ", married=" + married + ", age=" + age + ", degree=" + degree + ", interest=" + interest + "]";
	}
}
