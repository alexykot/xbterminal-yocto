from distutils.core import setup

setup(
    name='nfcpy',
    version='0.10.0',
    packages=[
        'nfc',
        'nfc.clf',
        'nfc.handover',
        'nfc.llcp',
        'nfc.ndef',
        'nfc.snep',
        'nfc.tag',
    ],
)
