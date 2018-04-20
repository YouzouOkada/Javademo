import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * Created by 葉蔵 on 2018/4/20.
 */
@org.springframework.context.annotation.Configuration
public class HumanConfiguration {
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider(){
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle","oracle");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }
}
