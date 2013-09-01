package my.test.querydsl;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QShippingPolicy is a Querydsl query type for QShippingPolicy
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QShippingPolicy extends com.mysema.query.sql.RelationalPathBase<QShippingPolicy> {

    private static final long serialVersionUID = -1754713006;

    public static final QShippingPolicy shippingPolicy = new QShippingPolicy("shipping_policy");

    public final NumberPath<Long> accountId = createNumber("account_id", Long.class);

    public final NumberPath<java.math.BigDecimal> cost = createNumber("cost", java.math.BigDecimal.class);

    public final DateTimePath<java.sql.Timestamp> createDate = createDateTime("create_date", java.sql.Timestamp.class);

    public final NumberPath<Byte> lastModifiedApp = createNumber("last_modified_app", Byte.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final NumberPath<Long> policyId = createNumber("policy_id", Long.class);

    public final StringPath policyName = createString("policy_name");

    public final NumberPath<Integer> shipCarrierId = createNumber("ship_carrier_id", Integer.class);

    public final NumberPath<Integer> shipServiceId = createNumber("ship_service_id", Integer.class);

    public final NumberPath<Byte> shipType = createNumber("ship_type", Byte.class);

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public final com.mysema.query.sql.PrimaryKey<QShippingPolicy> primary = createPrimaryKey(policyId);

    public final com.mysema.query.sql.ForeignKey<QShippingService> shippingPolicyShippingService1Fk = createForeignKey(shipServiceId, "shipping_service_id");

    public QShippingPolicy(String variable) {
        super(QShippingPolicy.class, forVariable(variable), "null", "shipping_policy");
    }

    @SuppressWarnings("all")
    public QShippingPolicy(Path<? extends QShippingPolicy> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "shipping_policy");
    }

    public QShippingPolicy(PathMetadata<?> metadata) {
        super(QShippingPolicy.class, metadata, "null", "shipping_policy");
    }

}

