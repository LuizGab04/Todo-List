package model;

public class JavaBeansTasks {
	private String id;
	private String taskName;
	private String user_id;

	public JavaBeansTasks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JavaBeansTasks(String id, String taskName, String user_id) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.user_id = user_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
