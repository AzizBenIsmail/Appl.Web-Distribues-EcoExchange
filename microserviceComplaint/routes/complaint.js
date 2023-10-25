const express=require('express');
const { getComplaints, addComplaint, updateComplaint, deleteComplaint } = require('../controllers/complaintControllers');
const router = express.Router();

/* GET home page. */
router.get('/complaint-service', function (req, res, next) {
    const responseData = {
        message: "I am complaint-service"
    };
    res.json(responseData);
});

/* Complaint routes */
router.get('/',getComplaints);// get complaints with controllers
router.post('/',addComplaint);
router.put('/:id',updateComplaint);
router.delete('/:id',deleteComplaint);


module.exports=router;

