import axios from "axios";

const restApi = axios.create({
    baseURL: 'http://localhost:8080'
})
export default restApi