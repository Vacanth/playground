package my.test.querydsl;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSubscriptionDetail is a Querydsl query type for QSubscriptionDetail
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QSubscriptionDetail extends com.mysema.query.sql.RelationalPathBase<QSubscriptionDetail> {

    private static final long serialVersionUID = -2107352416;

    public static final QSubscriptionDetail subscriptionDetail = new QSubscriptionDetail("subscription_detail");

    public final StringPath changeWho = createString("change_who");

    public final DateTimePath<java.sql.Timestamp> createDate = createDateTime("create_date", java.sql.Timestamp.class);

    public final NumberPath<Integer> descriptionCode = createNumber("description_code", Integer.class);

    public final DateTimePath<java.sql.Timestamp> modifyDate = createDateTime("modify_date", java.sql.Timestamp.class);

    public final NumberPath<Integer> subscriptionId = createNumber("subscription_id", Integer.class);

    public final StringPath subscriptionName = createString("subscription_name");

    public final com.mysema.query.sql.PrimaryKey<QSubscriptionDetail> primary = createPrimaryKey(subscriptionId);

    public final com.mysema.query.sql.ForeignKey<QAccountSubscription> _accountSubscriptionSubscriptionDetail1Fk = createInvForeignKey(subscriptionId, "subscription_id");

    public QSubscriptionDetail(String variable) {
        super(QSubscriptionDetail.class, forVariable(variable), "null", "subscription_detail");
    }

    @SuppressWarnings("all")
    public QSubscriptionDetail(Path<? extends QSubscriptionDetail> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "subscription_detail");
    }

    public QSubscriptionDetail(PathMetadata<?> metadata) {
        super(QSubscriptionDetail.class, metadata, "null", "subscription_detail");
    }

}

