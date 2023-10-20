const express=require('express');
const { getcomplaints, addcomplaint, updatecomplaint, deletecomplaint } = require('../controllers/complaintControllers');
const router = express.Router();
router.get('/',getcomplaints);// get complaints with controllers
router.post('/',addcomplaint);
router.put('/:id',updatecomplaint);
router.delete('/:id',deletecomplaint);

module.exports=router;

