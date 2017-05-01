#include <stdio.h>
#include <stdint.h>
#include <Python.h>
#include <itl/ITL_BSP_lib.h>
#include <itl/ITL_BSP_Error.h>

static PyObject *get_hw_version(PyObject *self) {
    uint8_t major;
    uint8_t minor;
    uint8_t modstate;
    ITL_BSP_GetHWVersion(&major, &minor, &modstate);
    PyObject *version = PyTuple_New(3);
    PyTuple_SetItem(version, 0, Py_BuildValue("i", major));
    PyTuple_SetItem(version, 1, Py_BuildValue("i", minor));
    PyTuple_SetItem(version, 2, Py_BuildValue("i", modstate));
    return version;

}

static PyObject *get_lib_version(PyObject *self) {
    uint8_t major;
    uint8_t minor;
    uint8_t build;
    ITL_BSP_GetLibVersion(&major, &minor, &build);
    PyObject *version = PyTuple_New(3);
    PyTuple_SetItem(version, 0, Py_BuildValue("i", major));
    PyTuple_SetItem(version, 1, Py_BuildValue("i", minor));
    PyTuple_SetItem(version, 2, Py_BuildValue("i", build));
    return version;
}

static PyObject *initialize(PyObject *self) {
    ITL_BSP_Init_Paysys();
    Py_RETURN_NONE;
}

static PyObject *add_credit(PyObject *self, PyObject *args) {
    uint32_t amount;
    if (!PyArg_ParseTuple(args, "i", &amount)) {
        return NULL;
    }
    ITL_BSP_AddCredit(amount);
    Py_RETURN_NONE;
}

static PyObject *get_payout_status(PyObject *self) {
    uint16_t status;
    status = ITL_BSP_GetPayoutStatus();
    return Py_BuildValue("i", status);
}

static PyObject *get_payout(PyObject *self) {
    uint16_t amount;
    ITL_BSP_GetPayout(&amount);
    return Py_BuildValue("i", amount);
}

static PyObject *pay_cash(PyObject *self, PyObject *args) {
    uint16_t amount;
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
    uint8_t status;
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

static PyObject *enable_display(PyObject *self) {
    ITL_BSP_Display_Enable(1);
    Py_RETURN_NONE;
}

static PyObject *disable_display(PyObject *self) {
    ITL_BSP_Display_Enable(0);
    Py_RETURN_NONE;
}

static PyObject *set_backlight_level(PyObject *self, PyObject *args) {
    uint8_t level;
    if (!PyArg_ParseTuple(args, "i", &level)) {
        return NULL;
    }
    ITL_BSP_Backlight_Level(level);
    Py_RETURN_NONE;
}

static PyMethodDef functions[] = {
    {"get_hw_version", (PyCFunction) get_hw_version,
     METH_NOARGS, "Get version information of the physical hardware."},
    {"get_lib_version", (PyCFunction) get_lib_version,
     METH_NOARGS, "Get version information of the BSP library."},
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
    {"enable_display", (PyCFunction) enable_display,
     METH_NOARGS, "Enable display."},
    {"disable_display", (PyCFunction) disable_display,
     METH_NOARGS, "Disable display."},
    {"set_backlight_level", (PyCFunction) set_backlight_level,
     METH_VARARGS, "Set backlight level."},
    {NULL, NULL, 0, NULL}
};

PyMODINIT_FUNC inititl_bsp(void) {
    PyObject *module;
    module = Py_InitModule("itl_bsp", functions);
    PyModule_AddIntConstant(module, "OK", ITL_BSP_OK);
    PyModule_AddIntConstant(module, "FAIL", ITL_BSP_FAIL);
    PyModule_AddIntConstant(module, "PAYOUT_IDLE", ITL_BSP_PAYOUT_IDLE);
    PyModule_AddIntConstant(module, "PAYOUT_PENDING", ITL_BSP_PAYOUT_PENDING);
    PyModule_AddIntConstant(module, "PAYOUT_COMPLETE", ITL_BSP_PAYOUT_COMPLETE);
    PyModule_AddIntConstant(module, "APM_IDLE", ITL_BSP_APM_IDLE);
    PyModule_AddIntConstant(module, "APM_ACTIVE", ITL_BSP_APM_ACTIVE);
    PyModule_AddIntConstant(module, "APM_OUTOFSERVICE", ITL_BSP_APM_OUTOFSERVICE);
    PyModule_AddIntConstant(module, "BACKLIGHT_OFF", BACKLIGHT_OFF);
    PyModule_AddIntConstant(module, "BACKLIGHT_LEVEL1", BACKLIGHT_LEVEL1);
    PyModule_AddIntConstant(module, "BACKLIGHT_LEVEL2", BACKLIGHT_LEVEL2);
    PyModule_AddIntConstant(module, "BACKLIGHT_LEVEL3", BACKLIGHT_LEVEL3);
    PyModule_AddIntConstant(module, "BACKLIGHT_LEVEL4", BACKLIGHT_LEVEL4);
    PyModule_AddIntConstant(module, "BACKLIGHT_LEVEL5", BACKLIGHT_LEVEL5);
    PyModule_AddIntConstant(module, "BACKLIGHT_LEVEL6", BACKLIGHT_LEVEL6);
    PyModule_AddIntConstant(module, "BACKLIGHT_LEVELMAX", BACKLIGHT_LEVELMAX);
}
