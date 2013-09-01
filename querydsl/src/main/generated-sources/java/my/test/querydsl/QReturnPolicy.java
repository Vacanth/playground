package my.test.querydsl;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QReturnPolicy is a Querydsl query type for QReturnPolicy
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QReturnPolicy extends com.mysema.query.sql.RelationalPathBase<QReturnPolicy> {

    private static final long serialVersionUID = -1212860716;

    public static final QReturnPolicy returnPolicy = new QReturnPolicy("return_policy");

    public final NumberPath<Long> accountId = createNumber("account_id", Long.class);

    public final DateTimePath<java.sql.Timestamp> createDate = createDateTime("create_date", java.sql.Timestamp.class);

    public final NumberPath<Byte> lastModifiedApp = createNumber("last_modified_app", Byte.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final NumberPath<Integer> payerId = createNumber("payer_id", Integer.class);

    public final StringPath policyDetails = createString("policy_details");

    public final NumberPath<Long> policyId = createNumber("policy_id", Long.class);

    public final StringPath policyName = createString("policy_name");

    public final NumberPath<Integer> returnAddrId = createNumber("return_addr_id", Integer.class);

    public final NumberPath<Integer> returnDuration = createNumber("return_duration", Integer.class);

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public final com.mysema.query.sql.PrimaryKey<QReturnPolicy> primary = createPrimaryKey(policyId);

    public QReturnPolicy(String variable) {
        super(QReturnPolicy.class, forVariable(variable), "null", "return_policy");
    }

    @SuppressWarnings("all")
    public QReturnPolicy(Path<? extends QReturnPolicy> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "return_policy");
    }

    public QReturnPolicy(PathMetadata<?> metadata) {
        super(QReturnPolicy.class, metadata, "null", "return_policy");
    }

}

