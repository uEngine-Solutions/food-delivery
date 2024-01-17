import orderYaml from "./order-openapi.yaml";
import riderYaml from "./rider-openapi.yaml";
import YAML from "json2yaml";

let apiSpec = "";

let orderSpec = YAML.stringify(orderYaml);
apiSpec += orderSpec;

let riderSpec = YAML.stringify(riderYaml);
apiSpec += riderSpec;


export default apiSpec;