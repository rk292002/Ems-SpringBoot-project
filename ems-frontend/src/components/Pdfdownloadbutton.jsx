import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { downloadPdf } from '../services/UserService';

const Pdfdownloadbutton = () => {
    const navigate = useNavigate();

    useEffect(() => {
        downloadPdf().then(() => {
            navigate('/employees'); // Redirect to the employees list page or any other page
        });
    }, [navigate]);

    return null;
};

export default Pdfdownloadbutton;
