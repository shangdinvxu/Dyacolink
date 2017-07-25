package Trace.GreenDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import Trace.GreenDao.heartrate;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table HEARTRATE.
*/
public class heartrateDao extends AbstractDao<heartrate, Long> {

    public static final String TABLENAME = "HEARTRATE";

    /**
     * Properties of entity heartrate.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StartTime = new Property(1, Integer.class, "startTime", false, "START_TIME");
        public final static Property Max = new Property(2, Integer.class, "max", false, "MAX");
        public final static Property Avg = new Property(3, Integer.class, "avg", false, "AVG");
        public final static Property FakeMaxRate = new Property(4, Integer.class, "fakeMaxRate", false, "FAKE_MAX_RATE");
        public final static Property FakeAvgRate = new Property(5, Integer.class, "fakeAvgRate", false, "FAKE_AVG_RATE");
    };

    private DaoSession daoSession;


    public heartrateDao(DaoConfig config) {
        super(config);
    }
    
    public heartrateDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'HEARTRATE' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'START_TIME' INTEGER UNIQUE ," + // 1: startTime
                "'MAX' INTEGER," + // 2: max
                "'AVG' INTEGER," + // 3: avg
                "'FAKE_MAX_RATE' INTEGER," + // 4: fakeMaxRate
                "'FAKE_AVG_RATE' INTEGER);"); // 5: fakeAvgRate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'HEARTRATE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, heartrate entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindLong(2, startTime);
        }
 
        Integer max = entity.getMax();
        if (max != null) {
            stmt.bindLong(3, max);
        }
 
        Integer avg = entity.getAvg();
        if (avg != null) {
            stmt.bindLong(4, avg);
        }
 
        Integer fakeMaxRate = entity.getFakeMaxRate();
        if (fakeMaxRate != null) {
            stmt.bindLong(5, fakeMaxRate);
        }
 
        Integer fakeAvgRate = entity.getFakeAvgRate();
        if (fakeAvgRate != null) {
            stmt.bindLong(6, fakeAvgRate);
        }
    }

    @Override
    protected void attachEntity(heartrate entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public heartrate readEntity(Cursor cursor, int offset) {
        heartrate entity = new heartrate( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // startTime
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // max
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // avg
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // fakeMaxRate
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5) // fakeAvgRate
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, heartrate entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStartTime(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setMax(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setAvg(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setFakeMaxRate(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setFakeAvgRate(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(heartrate entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(heartrate entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
