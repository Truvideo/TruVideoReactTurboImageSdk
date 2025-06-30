#import "TruvideoReactTurboImageSdk.h"
#import "truvideo_react_turbo_image_sdk-Swift.h"

@implementation TruvideoReactTurboImageSdk
RCT_EXPORT_MODULE()

- (NSNumber *)multiply:(double)a b:(double)b {
    NSNumber *result = @(a * b);
    return result;
}

- (void)getFilePath:(nonnull NSString *)fileName resolve:(nonnull RCTPromiseResolveBlock)resolve reject:(nonnull RCTPromiseRejectBlock)reject {
  
  TruvideoReactTurboImageSdkClass *tvrtcsc = [[TruvideoReactTurboImageSdkClass alloc] init];
  [tvrtcsc getResultPathWithPath:fileName resolve:resolve reject:reject];
}


- (void)launchImageEdit:(nonnull NSString *)inputPath outputPath:(nonnull NSString *)outputPath resolve:(nonnull RCTPromiseResolveBlock)resolve reject:(nonnull RCTPromiseRejectBlock)reject { 
  TruvideoReactTurboImageSdkClass *tvrtcsc = [[TruvideoReactTurboImageSdkClass alloc] init];
  [tvrtcsc launchImageEditWithInputPath:inputPath outputPath:outputPath resolve:resolve reject:reject];
}

- (void)edit:(nonnull NSString *)imagePath resultPath:(nonnull NSString *)resultPath rotation:(nonnull NSString *)rotation cropInformation:(nonnull NSString *)cropInformation horizontalFlip:(BOOL)horizontalFlip verticalFlip:(BOOL)verticalFlip width:(double)width height:(double)height outputFormat:(nonnull NSString *)outputFormat compressionQuality:(double)compressionQuality resolve:(nonnull RCTPromiseResolveBlock)resolve reject:(nonnull RCTPromiseRejectBlock)reject { 
  
}


- (void)getInfo:(nonnull NSString *)imagePath resolve:(nonnull RCTPromiseResolveBlock)resolve reject:(nonnull RCTPromiseRejectBlock)reject { 
  TruvideoReactTurboImageSdkClass *tvrtcsc = [[TruvideoReactTurboImageSdkClass alloc] init];
  [tvrtcsc getInfoWithInputPath:imagePath resolve:resolve reject:reject];
}



- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeTruvideoReactTurboImageSdkSpecJSI>(params);
}

@end
