
package bcccp.tickets.season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SeasonTicket implements ISeasonTicket {
	
	private List<IUsageRecord> usages;
	private IUsageRecord currentUsage = null;
	
	private String ticketId;
	private String carparkId;
	private long startValidPeriod;
	private long endValidPeriod;
	
	public SeasonTicket (String ticketId, 
			             String carparkId, 
			             long startValidPeriod,
			             long endValidPeriod) {
		this.ticketId = ticketId;
		this.carparkId =carparkId;
		this.startValidPeriod = startValidPeriod;
		this.endValidPeriod = endValidPeriod;
		usages = new ArrayList<IUsageRecord>();
		// Implemented constructor
	}

	@Override
	//test to get the ID
	@Test  
	public String getId() {
		return ticketId;
		// Auto-generated method stub
		
	}

	@Override
	//Test to get the CarparkId
	@Test 
	public String getCarparkId() {
		// Auto-generated method stub
		return carparkId;
	}

	@Override
	//Test to get the startValidPeriod
	@Test
	public long getStartValidPeriod() {
		//  Auto-generated method stub
		return startValidPeriod;
	}

	@Override
	//Test to Get the End ValidPeriod
	@Test
	public long getEndValidPeriod() {
		// Auto-generated method stub
		return endValidPeriod;
	}

	@Override
	@test
	//test to get the use time
	public boolean inUse() {
		// Auto-generated method stub
		return currentUsage != null ;
	}

	@Override
	@test
	//test to get the RecordUsage
	public void recordUsage(IUsageRecord record) {
		currentUsage = record;
		if (!usages.contains(record) ) {
			usages.add(record);
		}
		//  Auto-generated method stub
		
	}

	@Override
	//test to get the currentRecord
	@Test
	public IUsageRecord getCurrentUsageRecord() {
		//  Auto-generated method stub
		return currentUsage;
	}

	@Override
	//test to get the endUsage
	@Test
	public void endUsage(long dateTime) {
		if (currentUsage == null) throw new RuntimeException("SeasonTicket.endUsage : ticket is not in use");
		
		currentUsage.finalise(dateTime);
		currentUsage = null;
		// Auto-generated method stub
		
	}

	@Override
	//test to get the list the usage records
	@Test
	public List<IUsageRecord> getUsageRecords() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(usages);
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carpark    : " + carparkId + "\n" +
		       "Ticket No  : " + ticketId + "\n" );
		for (IUsageRecord usage : usages) {
			builder.append(usage.toString() + "\n");
		}
		return builder.toString();
	}


}
