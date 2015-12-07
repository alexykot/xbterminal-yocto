from distutils.core import setup, Extension

itl_bsp = Extension(
    'itl_bsp',
    sources=['extension.c'],
    libraries=['ITL_BSP'],
)

setup(name='itl_bsp',
      version='1.0',
      description='Python bindings for ITL BSP library',
      ext_modules=[itl_bsp])
