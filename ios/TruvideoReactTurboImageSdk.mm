#import "TruvideoReactTurboImageSdk.h"

@implementation TruvideoReactTurboImageSdk
RCT_EXPORT_MODULE()

- (NSNumber *)multiply:(double)a b:(double)b {
    NSNumber *result = @(a * b);

    return result;
}

- (void)getFilePath:(nonnull NSString *)fileName resolve:(nonnull RCTPromiseResolveBlock)resolve reject:(nonnull RCTPromiseRejectBlock)reject { 
  TruvideoReactTurboImageSdk *tvrtcsc = [[TruvideoReactTurboImageSdk alloc] init];
  [tvrtcsc getFilePath:fileName resolve:resolve reject:reject];
}


- (void)launchImageEdit:(nonnull NSString *)inputPath outputPath:(nonnull NSString *)outputPath resolve:(nonnull RCTPromiseResolveBlock)resolve reject:(nonnull RCTPromiseRejectBlock)reject { 
  TruvideoReactTurboImageSdk *tvrtcsc = [[TruvideoReactTurboImageSdk alloc] init];
  [tvrtcsc launchImageEdit:inputPath outputPath:outputPath resolve:resolve reject:reject];
}


- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeTruvideoReactTurboImageSdkSpecJSI>(params);
}

@end
