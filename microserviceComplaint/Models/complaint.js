const mongoose = require("mongoose");
const complaintSchema = new mongoose.Schema(
    {
        object: String,
        content: String,
    }
);
const complaint = mongoose.model("complaint", complaintSchema);
module.exports=complaint;