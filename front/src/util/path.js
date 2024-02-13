
export const BASE_URL = 'http://localhost:8080'
export const API_URL = {
    SIGNUP: BASE_URL + '/signup',
    CHECK_ID: (checkId) => `${BASE_URL}/signup?check_id=${checkId}`,
    LOGIN: BASE_URL + '/session',
    LOGOUT: BASE_URL + '/logout'
}