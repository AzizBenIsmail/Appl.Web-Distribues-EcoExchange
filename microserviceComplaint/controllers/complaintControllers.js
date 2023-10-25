const complaintModel = require("../Models/complaint");

const addComplaint = async (req, res, next) => {
    try {
        const { object, content } = req.body;
        console.log(req.body);
        const complaint = new complaintModel({ object, content });
        const addedcomplaint = await complaint.save();
        res.status(200).json(addedcomplaint);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};
const getComplaints = async (req, res, next) => {
    try {
        const complaints = await complaintModel.find();
        if (!complaints || complaints.length === 0) {
            throw new Error("complaints not found !");
        }
        res.status(200).json({ complaints });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};
const updateComplaint = async (req, res, next) => {
    try {
        const { id } = req.params;
        const { object, content } = req.body;
        const checkIfcomplaintExists = await complaintModel.findById(id);
        if (!checkIfcomplaintExists) {
            throw new Error("complaint not found !");
        }
        updated = await complaintModel.findByIdAndUpdate(
            id,
            {
                $set: { object, content },
            },
            { new: true },
        );
        res.status(200).json({ updated });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};
const deleteComplaint = async (req, res, next) => {
    try {
        const { id } = req.params;
        const checkIfcomplaintExists = await complaintModel.findById(id);
        if (!checkIfcomplaintExists) {
            throw new Error("Complaint not found !");
        }
        await complaintModel.findByIdAndDelete(id);
        res.status(200).json("Deleted");
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};
module.exports = {
    addComplaint,
    getComplaints,
    deleteComplaint,
    updateComplaint,
};
