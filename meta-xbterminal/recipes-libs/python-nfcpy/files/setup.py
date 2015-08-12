from distutils.core import setup

setup(
    name='nfcpy',
    version='0.9.2',
    packages=[
        'nfc',
        'nfc.dev',
        'nfc.handover',
        'nfc.llcp',
        'nfc.ndef',
        'nfc.snep',
        'nfc.tag',
    ],
)
