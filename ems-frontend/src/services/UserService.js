import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listusers = () => {
    return axios.get(REST_API_BASE_URL);
}

export const createuser = (user) => axios.post(REST_API_BASE_URL, user);

export const downloadCSV = () => {
    return axios({
        url: 'http://localhost:8080/api/employees/employees/export',
        method: 'GET',
        responseType: 'blob', // important
    }).then((response) => {
        const url = window.URL.createObjectURL(new Blob([response.data], { type: 'text/csv' }));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', 'employees.csv'); // correct extension
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    }).catch(error => {
        console.error('Error downloading the CSV file', error);
    });
}

export const downloadPdf = () => {
    return axios({
        url: 'http://localhost:8080/api/employees/employees/exportpdf',
        method: 'GET',
        responseType: 'blob', // important to handle the response as a blob
    }).then((response) => {
        const url = window.URL.createObjectURL(new Blob([response.data], { type: 'application/pdf' }));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', 'employees.pdf'); // correct extension
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    }).catch(error => {
        console.error('Error downloading the PDF', error);
    });
};

export const downloadExcel = () => {
    return axios({
        url: 'http://localhost:8080/api/employees/employees/exportexcel',
        method: 'GET',
        responseType: 'blob', // important to handle the response as a blob
    }).then((response) => {
        const url = window.URL.createObjectURL(new Blob([response.data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' }));
        const link = document.createElement('a');
        link.href = url;
        link.setAttribute('download', 'employees.xlsx'); // correct extension
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    }).catch(error => {
        console.error('Error downloading the Excel file', error);
    });
};
