package configurations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationConfig {
    private KafkaConfig kafkaConfig;
    private String inputTopic;
    private String outputTopic;
}
