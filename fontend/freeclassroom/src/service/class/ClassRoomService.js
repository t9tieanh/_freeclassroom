import axios from "../../utils/CustomAxios";

const baseURL = "classroom"

const getClassRoomByTeacher = async (page,limit) => {
    return await axios.get(baseURL,{
        params: {
            page: page,
            limit: limit
        }
    })
}

export {getClassRoomByTeacher}