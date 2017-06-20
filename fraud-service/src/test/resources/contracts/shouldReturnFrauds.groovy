import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()
        url "/fraud"
    }
    response {
        status 200
        body(["marcin", "josh"])
    }
}