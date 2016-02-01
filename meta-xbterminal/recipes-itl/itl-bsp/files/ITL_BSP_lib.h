#ifndef _ITL_BSP_LIB_H_
#define _ITL_BSP_LIB_H_

#if defined (__cplusplus)
extern "C" {
#endif

//=============================================================================
// Return Codes
//=============================================================================
enum
{
	ITL_BSP_OK			= 0,
	ITL_BSP_FAIL		= 1,
};


//=============================================================================
// Definitions
//=============================================================================
enum
{
	BSP_LED_GREEN			= 0x01,
	BSP_LED_BLUE			= 0x02,
	BSP_LED_ORANGE			= 0x04,
	BSP_LED_RED				= 0x08
};

//=============================================================================
// Function Definitions
//=============================================================================
uint16_t ITL_BSP_GetLibVersion(uint8_t *major, uint8_t *minor, uint8_t *build);
void ITL_BSP_Buzz( int tone, int duration );
void ITL_BSP_SetLeds(int leds);
void ITL_BSP_ClearLeds(int leds);
uint8_t ITL_BSP_GetPushButton(void);

void ITL_BSP_WirelessResetAssert(void);
void ITL_BSP_WirelessResetDeassert(void);
void ITL_BSP_WirelessPowerEnAssert(void);
void ITL_BSP_WirelessPowerEnDeassert(void);

void ITL_BSP_MircoUpdate(char *filename, uint8_t force_update);

uint8_t ITL_BSP_HopperInit(uint8_t channel);
void ITL_BSP_HopperSetPulseLength(uint8_t channel, uint16_t pulse_length);
void ITL_BSP_HopperSetPulseTimeout(uint8_t channel, uint16_t timeout);
uint8_t ITL_BSP_HopperCheckChannelIdle(uint8_t channel);

void ITL_BSP_HopperccTalkInit(void);
uint16_t ITL_BSP_GetPayout(uint16_t *payout);
uint16_t ITL_BSP_AddCredit(uint32_t credit);

uint16_t ITL_BSP_GetPulses(uint8_t channel, uint16_t *pulses);
uint16_t ITL_BSP_SendPulses(uint8_t channel, uint16_t pulses);

#if defined (__cplusplus)
}
#endif

#endif // _ITL_BSP_LIB_H_
