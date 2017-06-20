import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should produce a fraud message"
    label "fraud_message"
    input {
        triggeredBy("triggerMessage()")
    }
    outputMessage {
        sentTo "frauds"
        body([surname: "Bob"])
    }
}