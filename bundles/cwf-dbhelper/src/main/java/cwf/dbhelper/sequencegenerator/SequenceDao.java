package cwf.dbhelper.sequencegenerator;

import cwf.dbhelper.sequencegenerator.SequenceException;

public interface SequenceDao {
	int getNextSequenceId(String key) throws SequenceException;
}