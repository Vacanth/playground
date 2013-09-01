package my.test.querydsl.hibernate;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import my.test.querydsl.hib.Account;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.ArrayPath;
import com.mysema.query.types.path.DateTimePath;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = -218873279;

    public static final QAccount account = new QAccount("account");

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final StringPath alternateEmail = createString("alternateEmail");

    public final NumberPath<Long> billingAddrId = createNumber("billingAddrId", Long.class);

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    public final NumberPath<Byte> currencyCodeIso3 = createNumber("currencyCodeIso3", Byte.class);

    public final StringPath emailAddr = createString("emailAddr");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Byte> language = createNumber("language", Byte.class);

    public final NumberPath<Byte> lastModifiedApp = createNumber("lastModifiedApp", Byte.class);

    public final DateTimePath<java.util.Date> lastModifiedDate = createDateTime("lastModifiedDate", java.util.Date.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath middleName = createString("middleName");

    public final StringPath password = createString("password");

    public final ArrayPath<byte[], Byte> picture = createArray("picture", byte[].class);

    public final NumberPath<Long> registrationAddrId = createNumber("registrationAddrId", Long.class);

    public final StringPath roles = createString("roles");

    public final StringPath salt = createString("salt");

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QAccount(Path<? extends Account> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata<?> metadata) {
        super(Account.class, metadata);
    }

}

