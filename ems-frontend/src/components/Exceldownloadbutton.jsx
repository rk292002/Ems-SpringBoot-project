import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { downloadExcel } from '../services/UserService';

const Exceldownloadbutton = () => {
    const navigate = useNavigate();

    useEffect(() => {
        downloadExcel().then(() => {
            navigate('/employees'); // Redirect to the employees list page or any other page
        });
    }, [navigate]);

    return null;
};

export default Exceldownloadbutton;
