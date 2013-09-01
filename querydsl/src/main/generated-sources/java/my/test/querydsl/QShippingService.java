package my.test.querydsl;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QShippingService is a Querydsl query type for QShippingService
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QShippingService extends com.mysema.query.sql.RelationalPathBase<QShippingService> {

    private static final long serialVersionUID = -474342507;

    public static final QShippingService shippingService = new QShippingService("shipping_service");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final StringPath name = createString("name");

    public final NumberPath<Byte> serviceCategory = createNumber("service_category", Byte.class);

    public final NumberPath<Integer> shippingServiceId = createNumber("shipping_service_id", Integer.class);

    public final NumberPath<Byte> site = createNumber("site", Byte.class);

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public final NumberPath<Byte> type = createNumber("type", Byte.class);

    public final com.mysema.query.sql.PrimaryKey<QShippingService> primary = createPrimaryKey(shippingServiceId);

    public final com.mysema.query.sql.ForeignKey<QShippingPolicy> _shippingPolicyShippingService1Fk = createInvForeignKey(shippingServiceId, "ship_service_id");

    public QShippingService(String variable) {
        super(QShippingService.class, forVariable(variable), "null", "shipping_service");
    }

    @SuppressWarnings("all")
    public QShippingService(Path<? extends QShippingService> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "shipping_service");
    }

    public QShippingService(PathMetadata<?> metadata) {
        super(QShippingService.class, metadata, "null", "shipping_service");
    }

}

