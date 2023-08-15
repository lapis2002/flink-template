package configurations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaConfig {
    private String bootstrapServers;
    private String applicationId;
    private String saslJaasConfig;
}
