package hsm;

import java.util.Date;

public class InternalInfo {

	@Override
	public String toString() {
		return "InternalInfo [creationdate=" + creationdate + ", createdby=" + createdby + ", lastmodified="
				+ lastmodified + ", lastmodifiedby=" + lastmodifiedby + "]";
	}


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
