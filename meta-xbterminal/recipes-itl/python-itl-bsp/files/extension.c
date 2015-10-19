#include <stdio.h>
#include <stdint.h>
#include <Python.h>
#include <itl/ITL_BSP_lib.h>

static PyObject*
add_credit(PyObject* self, PyObject* args)
{
    ITL_BSP_AddCredit(100);
    Py_RETURN_NONE;
}

static PyObject*
get_payout(PyObject* self, PyObject* args)
{
    uint16_t payout;
    ITL_BSP_GetPayout(&payout);
    Py_RETURN_NONE;
}

static PyMethodDef functions[] =
{
    {"add_credit", add_credit, METH_VARARGS, "Add credit."},
    {"get_payout", get_payout, METH_VARARGS, "Get payout."},
    {NULL, NULL, 0, NULL}
};

PyMODINIT_FUNC
inititl_bsp(void)
{
    (void) Py_InitModule("itl_bsp", functions);
}
