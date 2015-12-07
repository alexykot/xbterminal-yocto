#include <stdio.h>
#include <stdint.h>
#include <Python.h>
#include <itl/ITL_BSP_lib.h>

static PyObject*
add_credit(PyObject* self, PyObject* args)
{
    int amount;
    if (!PyArg_ParseTuple(args, "i", &amount)) {
        return NULL;
    }
    ITL_BSP_AddCredit(amount);
    Py_RETURN_NONE;
}

static PyObject*
get_payout(PyObject* self, PyObject* args)
{
    uint16_t amount;
    ITL_BSP_GetPayout(&amount);
    return Py_BuildValue("i", amount);
}

static PyMethodDef functions[] =
{
    {"add_credit", add_credit, METH_VARARGS, "Add credit."},
    {"get_payout", get_payout, METH_NOARGS, "Get payout."},
    {NULL, NULL, 0, NULL}
};

PyMODINIT_FUNC
inititl_bsp(void)
{
    (void) Py_InitModule("itl_bsp", functions);
}
