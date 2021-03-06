package com.xing.module.quality.db;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.xing.module.quality.bean.QCRImage;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "QCRImage".
*/
public class QCRImageDao extends AbstractDao<QCRImage, Long> {

    public static final String TABLENAME = "QCRImage";

    /**
     * Properties of entity QCRImage.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property QcrId = new Property(1, Long.class, "qcrId", false, "QCR_ID");
        public final static Property ImageName = new Property(2, String.class, "imageName", false, "IMAGE_NAME");
        public final static Property ImageUrl = new Property(3, String.class, "imageUrl", false, "IMAGE_URL");
        public final static Property ImageLocalUrl = new Property(4, String.class, "imageLocalUrl", false, "IMAGE_LOCAL_URL");
        public final static Property ImageShowname = new Property(5, String.class, "imageShowname", false, "IMAGE_SHOWNAME");
    }

    private Query<QCRImage> qCRecord_QcrImageListQuery;

    public QCRImageDao(DaoConfig config) {
        super(config);
    }
    
    public QCRImageDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"QCRImage\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"QCR_ID\" INTEGER NOT NULL ," + // 1: qcrId
                "\"IMAGE_NAME\" TEXT," + // 2: imageName
                "\"IMAGE_URL\" TEXT," + // 3: imageUrl
                "\"IMAGE_LOCAL_URL\" TEXT," + // 4: imageLocalUrl
                "\"IMAGE_SHOWNAME\" TEXT);"); // 5: imageShowname
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"QCRImage\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, QCRImage entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getQcrId());
 
        String imageName = entity.getImageName();
        if (imageName != null) {
            stmt.bindString(3, imageName);
        }
 
        String imageUrl = entity.getImageUrl();
        if (imageUrl != null) {
            stmt.bindString(4, imageUrl);
        }
 
        String imageLocalUrl = entity.getImageLocalUrl();
        if (imageLocalUrl != null) {
            stmt.bindString(5, imageLocalUrl);
        }
 
        String imageShowname = entity.getImageShowname();
        if (imageShowname != null) {
            stmt.bindString(6, imageShowname);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, QCRImage entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getQcrId());
 
        String imageName = entity.getImageName();
        if (imageName != null) {
            stmt.bindString(3, imageName);
        }
 
        String imageUrl = entity.getImageUrl();
        if (imageUrl != null) {
            stmt.bindString(4, imageUrl);
        }
 
        String imageLocalUrl = entity.getImageLocalUrl();
        if (imageLocalUrl != null) {
            stmt.bindString(5, imageLocalUrl);
        }
 
        String imageShowname = entity.getImageShowname();
        if (imageShowname != null) {
            stmt.bindString(6, imageShowname);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public QCRImage readEntity(Cursor cursor, int offset) {
        QCRImage entity = new QCRImage( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // qcrId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // imageName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // imageUrl
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // imageLocalUrl
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // imageShowname
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, QCRImage entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setQcrId(cursor.getLong(offset + 1));
        entity.setImageName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setImageUrl(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setImageLocalUrl(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setImageShowname(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(QCRImage entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(QCRImage entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(QCRImage entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "qcrImageList" to-many relationship of QCRecord. */
    public List<QCRImage> _queryQCRecord_QcrImageList(Long qcrId) {
        synchronized (this) {
            if (qCRecord_QcrImageListQuery == null) {
                QueryBuilder<QCRImage> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.QcrId.eq(null));
                qCRecord_QcrImageListQuery = queryBuilder.build();
            }
        }
        Query<QCRImage> query = qCRecord_QcrImageListQuery.forCurrentThread();
        query.setParameter(0, qcrId);
        return query.list();
    }

}
