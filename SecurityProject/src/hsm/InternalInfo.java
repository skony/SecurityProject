package hsm;

import java.sql.Date;

public class InternalInfo {

	Date creationdate;
	int createdby;
	Date lastmodified;
	int lastmodifiedby;
	
	
	public Date getCreationdate() {
		return creationdate;
	}


	public int getCreatedby() {
		return createdby;
	}


	public Date getLastmodified() {
		return lastmodified;
	}


	public int getLastmodifiedby() {
		return lastmodifiedby;
	}


	public InternalInfo(Date creationdate, int createdby, Date lastmodified, int lastmodifiedby) {
		super();
		this.creationdate = creationdate;
		this.createdby = createdby;
		this.lastmodified = lastmodified;
		this.lastmodifiedby = lastmodifiedby;
	}
	
}
