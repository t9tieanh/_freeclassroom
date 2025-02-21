import axios from "../../utils/CustomAxios";

const baseURL = "auth/"

const signUp = async (image, email, name, phone, username, password, role) => {
    const form = new FormData();
    form.append('imageFile', image);
    form.append('email', email);
    form.append('name',name)
    form.append('phone',phone)
    form.append('username', username);
    form.append('password', password);
    form.append('role', role);

    return await axios.post(`${baseURL}sign-up`, form)
}

export default signUp