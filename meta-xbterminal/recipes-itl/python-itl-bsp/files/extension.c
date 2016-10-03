#include <stdio.h>
#include <stdint.h>
#include <Python.h>
#include <itl/ITL_BSP_lib.h>
#include <itl/ITL_BSP_Error.h>

static PyObject *initialize(PyObject *self) {
    ITL_BSP_Init_Paysys();
    Py_RETURN_NONE;
}

static PyObject *add_credit(PyObject *self, PyObject *args) {
    int amount;
    if (!PyArg_ParseTuple(args, "i", &amount)) {
        return NULL;
    }
    ITL_BSP_AddCredit(amount);
    Py_RETURN_NONE;
}

static PyObject *get_payout_status(PyObject *self) {
    int status;
    status = ITL_BSP_GetPayoutStatus();
    return Py_BuildValue("i", status);
}

static PyObject *get_payout(PyObject *self) {
    uint16_t amount;
    ITL_BSP_GetPayout(&amount);
    return Py_BuildValue("i", amount);
}

static PyObject *pay_cash(PyObject *self, PyObject *args) {
    int amount;
    if (!PyArg_ParseTuple(args, "i", &amount)) {
        return NULL;
    }
    ITL_BSP_PayoutCash(amount);
    Py_RETURN_NONE;
}

static PyObject *get_apm_status(PyObject *self) {
    uint8_t status;
    ITL_BSP_APMGetStatus(&status);
    return Py_BuildValue("i", status);
}

static PyObject *set_apm_status(PyObject *self, PyObject *args) {
    int status;
    if (!PyArg_ParseTuple(args, "i", &status)) {
        return NULL;
    }
    ITL_BSP_APMSetStatus(status);
    Py_RETURN_NONE;
}

static PyObject *write_ndef(PyObject *self, PyObject *args) {
    char *message;
    if (!PyArg_ParseTuple(args, "s", &message)) {
        return NULL;
    }
    ITL_BSP_WriteNDEF(message);
    Py_RETURN_NONE;
}

static PyObject *erase_ndef(PyObject *self) {
    ITL_BSP_EraseNDEF();
    Py_RETURN_NONE;
}

static PyMethodDef functions[] = {
    {"initialize", (PyCFunction) initialize,
     METH_NOARGS, "Perform initialization."},
    {"add_credit", (PyCFunction) add_credit,
     METH_VARARGS, "Add credit."},
    {"get_payout_status", (PyCFunction) get_payout_status,
     METH_NOARGS, "Get payout status."},
    {"get_payout", (PyCFunction) get_payout,
     METH_NOARGS, "Get payout."},
    {"pay_cash", (PyCFunction) pay_cash,
     METH_VARARGS, "Pay cash."},
    {"get_apm_status", (PyCFunction) get_apm_status,
     METH_NOARGS, "Get APM status."},
    {"set_apm_status", (PyCFunction) set_apm_status,
     METH_VARARGS, "Set APM status."},
    {"write_ndef", (PyCFunction) write_ndef,
     METH_VARARGS, "Write NDEF message."},
    {"erase_ndef", (PyCFunction) erase_ndef,
     METH_NOARGS, "Erase NDEF message."},
    {NULL, NULL, 0, NULL}
};

PyMODINIT_FUNC inititl_bsp(void) {
    (void) Py_InitModule("itl_bsp", functions);
}
